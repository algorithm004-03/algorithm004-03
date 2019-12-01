var genes = []rune{'A', 'C', 'G', 'T'}

func minMutation(start string, end string, bank []string) int {
	if len(bank) == 0 {
		return -1
	}

	bankSet := make(map[string]struct{}, len(bank))
	for _, g := range bank {
		bankSet[g] = struct{}{}
	}

	if _, ok := bankSet[end]; !ok {
		return -1
	}

	delete(bankSet, end)

	beginSet := make(map[string]struct{})
	endSet := make(map[string]struct{})
	visited := make(map[string]struct{})
	beginSet[start] = struct{}{}
	endSet[end] = struct{}{}

	times := 1
	for len(beginSet) > 0 {
		newBeginSet := make(map[string]struct{})
		for geneStr, _ := range beginSet {
			curGenes := []rune(geneStr)
			for i, gene := range curGenes {
				for _, g := range genes {
					if g == gene {
						continue
					}

					curGenes[i] = g
					mutatedGenes := string(curGenes)
					if _, ok := endSet[mutatedGenes]; ok {
						return times
					}

					if _, ok := bankSet[mutatedGenes]; !ok {
						continue
					}

					if _, ok := visited[mutatedGenes]; ok {
						continue
					}

					newBeginSet[mutatedGenes] = struct{}{}
					visited[mutatedGenes] = struct{}{}
				}

				curGenes[i] = gene
			}
		}

		beginSet = newBeginSet
		times++
		if len(beginSet) > len(endSet) {
			beginSet, endSet = endSet, beginSet
		}
	}

	return -1
}
