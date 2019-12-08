class Solution {
    private int cnt;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        sort(nums, Arrays.copyOf(nums, len), 0, len - 1);
        return cnt;
    }

    private void sort(int[] src, int[] dest, int s, int e) {
        if (s < e) {
            int mid = (s + e) >> 1;
            sort(dest, src, s, mid);
            sort(dest, src, mid + 1, e);

            merge(src, dest, s, mid, e);
        }
    }

    private void merge(int[] src, int[] dest, int s, int mid, int e) {
        int i = s, j = mid + 1, k = s;

        //独立出来做了一遍count重要逆序对
        while (i <= mid && j <= e) {
            if ((long) src[i] > 2 * ((long) src[j])) {
                cnt += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        i = s;
        j = mid + 1;

        while (i <= mid && j <= e) {
            if (src[i] <= src[j]) {
                dest[k++] = src[i++];
            } else {

                dest[k++] = src[j++];
            }
        }

        while (i <= mid) {
            dest[k++] = src[i++];
        }

        while (j <= e) {
            dest[k++] = src[j++];
        }
    }
}