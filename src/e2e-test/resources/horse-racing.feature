Feature: Horse Racing

	Background: 
		Given the track length is 120 yards # 1 furlong
		And there are a maximum of 7 horses playing
		And the track has 7 lanes in it (numbered lanes 1 to 7)
		And each horse has a name
		And each horse will be in one lane
		
		Scenario: Reading the input data displays correct output
			
			Given the first line of input will contain names of horses ordered according to the lanes they're will be racing in
			And the rest of the lines will represent a ball throw
			When i start the horse race
			Then the output will be list of horses ordered by position in the race
			
		Scenario: Tossing ball
			
			Given there are 11 holes for each lane
			And each hole has a number # this is the number of the yards the horse will move
			And the numbers in the holes are the following: 5, 5, 5, 5, 10, 10, 10, 20, 20, 40, 60
			When a virtual player tosses a ball to a set of holes
			Then the horse belonging to the virtual player advances by the number of yards indicated by the hole number
			
		Scenario: Let's race!
		
			Given we have read the input 
			And each virtual player indicated by the input...
			When each virtual player is tossing the balls
			Then the winner will be the first horse to reach the goal (i.e. first horse to get 1 furlong)
			And the race ends here
			And the positions of other horses will be frozen despite more balls are thrown
			
		
		# Example test case
  		#  Test Input:
  		#
		#
		#  Star, Dakota, Cheyenne, Misty, Spirit
		#  1 60
		#  3 5
		#  4 5
		#  1 60
		#  4 10
		#  2 5
		#  5 10
		#  1 60
		#  3 20
		#  7 10
		#  1 40
		#  2 60
		#  
		#  
		#  Expected Output:
		#  
		#  
		#  Position, Lane, Horse name
		#  1, 1, Star
		#  2, 3, Cheyenne
		#  3, 4, Misty
		#  4, 5, Spirit
		#  5, 2, Dakota
		#   