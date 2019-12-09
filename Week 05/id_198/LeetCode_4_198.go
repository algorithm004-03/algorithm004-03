package leetcode

import "fmt"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {

	l1 := len(nums1)
	l2 := len(nums2)

	// end 1
	e1 := (l1 + l2) / 2
	// end 2
	e2 := e1
	if (l1+l2)%2 == 0 {

		e1 = e1 - 1
		e2 = e1 + 1
	}

	v1 := 0
	v2 := 0

	target := &nums1
	if len(nums1) == 0 {

		target = &nums2
	}
	curr := 0

	s1 := 0
	s2 := 0
	fmt.Printf("%d,%d\n", e1, e2)
	for {

		if s1+s2 == e1 {

			v1 = (*target)[curr]
		}
		if s1+s2 == e2 {

			v2 = (*target)[curr]
			break
		}

		c1 := 0
		c2 := 0
		if s1 < l1 {

			c1 = nums1[s1]
			if s2 < l2 {

				c2 = nums2[s2]
				if c2 > c1 {

					target = &nums2
					curr = s2

				} else {

					target = &nums1
					curr = s1
				}
			} else {

				c2 = nums1[s1]
				target = &nums1
				curr = s1

			}
			s1++
			continue
		}

		if s2 < l2 {

			target = &nums2
			s2++
			curr = s2
		}
	}

	return float64(v1+v2) / 2
}
