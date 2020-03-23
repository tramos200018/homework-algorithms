# Assignment 11 - Block Stacking

## The Files

My implementation has two files. BlockRep is the file that represents a block. It takes in the dimensions of the block and also determines the base area of the block. The Block file is main file that takes in the input file and prints out the height of the tallest possible tower using the given blocks. However, I was unable to get the printing of the tower correct.

First the program will ask to enter an input file. After entering the desired file, it will print out the height of the tallest possible tower.

## The output

For each of the trip requests in the input file, your program should output a neatly-formatted report to
the console that includes each leg of the trip with its distance and/or time (as appropriate), and the total
distance and/or time for the trip.

If the trip request asks for the shortest distance, the output might look something like the following.
(These are phony trips, to show you the output format; they are not related to the sample data file provided
above.)

    Shortest distance from Alton & Jamboree to MacArthur & Main
        Begin at Alton & Jamboree
        Continue to Main & Jamboree (1.1 miles)
        Continue to Jamboree & I-405N on ramp (0.3 miles)
        Continue to I-405N @ MacArthur (1.3 miles)
        Continue to MacArthur & I-405N off ramp (0.1 miles)
        Continue to MacArthur & Main (0.2 miles)
    Total distance: 3.0 miles

On the other hand, if the trip request asks for the shortest time, the output might look like this:

    Shortest driving time from Alton & Jamboree to MacArthur & Main
        Begin at Alton & Jamboree
        Continue to Alton & MacArthur (4 mins 48.8 secs)
        Continue to Main & MacArthur (1 min 38.7 secs)
    Total time: 6 mins 27.5 secs

When outputting a time, you should separate it into its components – hours, minutes, and seconds – as
appropriate. Here are some examples:

    32.5 secs
    2 mins 27.8 secs
    13 mins 0.0 secs
    3 hrs 13 mins 12.3 secs
    6 hrs 0 mins 0.0 secs

Don't show hours if there are zero of them. Don't show hours or minutes if there are zero of both of them.
All decimals in seconds should be rounded to a single digit after the decimal point.

The conversion to hours minutes and seconds is a bit tricky. Here is one way to approach it though you
might prefer to find your own way. Suppose timeHours is the double value you are trying to convert:

1. Find the hours (`numHours`) by casting `timeHours` to an `int`. This will truncate to the number of hours.
2. Find the fractional hours (`fractionalHours`)) left by calculating `timeHours - numHours`.
3. (Here is the tricky part:) You could convert this to seconds by multiplying by `60*60 (= 3600)`, but
instead calculate the number of tenths of a seconds left by multiplying by 36000 and then rounding to
the nearest `int`. `int tenthSeconds = (int)Math.round(fractionalHours * 36000)`.
4. Now it is easy to calculate the number of minutes (`minutes`) by dividing by 600 (the number of tenths
of a second in a minute).
5. Calculate `tenthSecondsLeft = tenthSeconds - 600 * minutes`.
6. We bet you'll be able to figure out how to convert this last value to the appropriate number of seconds
(to the nearest 1/10th).

We'll leave it to you to figure out the logic to get the correct units to appear as specified. Notice the last
example in particular, where minutes are shown even if there are 0 of them.

