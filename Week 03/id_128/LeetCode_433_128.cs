
public class Solution
{
    public int MinMutation(string start, string end, string[] bank)
    {
        if (start.Equals(end)) return 0;

        var geneBank = new HashSet<string>();
        foreach (var gene in bank)
        {
            geneBank.Add(gene);
        }

        char[] nucleotides = new char[] { 'A', 'C', 'G', 'T' };
        int level = 0;

        var queue = new Queue<string>();
        queue.Enqueue(start);

        while (queue.Count() > 0)
        {
            int size = queue.Count();
            while (size-- > 0)
            {
                string currGene = queue.Dequeue();
                if (currGene.Equals(end)) return level;
                var charArray = currGene.ToCharArray();
                for (int i = 0; i < charArray.Length; i++)
                {
                    char temp = charArray[i];
                    foreach (char nucleotide in nucleotides)
                    {
                        charArray[i] = nucleotide;
                        var mutation = new String(charArray);
                        if (geneBank.Contains(mutation))
                        {
                            geneBank.Remove(mutation);
                            queue.Enqueue(mutation);
                        }
                    }
                    charArray[i] = temp;
                }
            }
            level++;
        }
        return -1;
    }
}

