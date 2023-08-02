package com.argynsagash.leetcode.array101

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) {
            return false
        }

        val direction = mutableSetOf<String>()
        var max = arr[0]
        var vector = 0
        var counter = 1
        while (counter < arr.size) {
            when (vector) {
                0 -> if (arr[counter] > max) {
                    max = arr[counter]
                    direction.add("up")
                    counter++
                } else if (arr[counter] == max) return false
                else {
                    vector = 1
                    direction.add("max height" + max)
                    max = arr[counter]
                }

                1 -> if (arr[counter] > max) return false
                else if ((counter + 1) < arr.size && arr[(counter + 1)] == arr[counter]) return false
                else {
                    max = arr[counter]
                    direction.add("down")
                    counter++
                }
            }

        }
        return direction.size == 3
    }

    //version_2
    fun validMountainArrayV2(arr: IntArray): Boolean {

        if (arr.size < 3) return false

        // let's find out how many C
        val trailLength = arr.size
        // and will be counting each step we made
        var stepsMade = 0

        // with this cicle we will be climbing up,
        // each step in our cicle we check 2 conditions:
        // 1) Is the next step the end of our trail
        // 2) Is the next step is higher than current step
        while (stepsMade + 1 < trailLength && arr[stepsMade] < arr[stepsMade + 1])
            stepsMade++

        //now it's time to check corner cases
        // if we made no steps than it means there is no uphill in our trail
        // if steps equals trailLength than there is no downhill
        // With any of this scenarios we understand that our trail is not valid
        if (stepsMade == 0 || stepsMade == trailLength - 1)
            return false

        // if uphill is valid than we start to go downhill
        // and check same conditions but the next step should be lower
        // than current step
        while (stepsMade + 1 < trailLength && arr[stepsMade] > arr[stepsMade + 1])
            stepsMade++

        // now it is time for final check
        // if we go back to our cicles we coud see that we count our steps
        // only when next step is higher (uphill) or lower (downhill)
        // than current step
        // it means that we do not count steps if it is a flat section
        // or unexpected downhill before reaching the peak of our trail
        // so if our steps equals length of the trail than all conditions are met and trail is valid
        // otherwise there were skips and trail is not valid
        return stepsMade == trailLength - 1
    }
}