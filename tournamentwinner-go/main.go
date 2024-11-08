package main

const HOME_TEAM_WON = 1

//competitions = [
//		["HTML", "C#"],
//		["C#", "Python"],
//		["Python", "HTML"],
//	]

//results = [0, 0, 1]

// 0 means the away team won and 1 means the home team

//Winner: "Python"
// C# beats HTML, Python beats C#, and Python beats HTML.
// HTML - 0 points
// C# - 3 points
// Python - 6 points

func TournamentWinner(competitions [][]string, results []int) string {
	winner := ""
	maxScore := 0
	final := make(map[string]int)

	for i := 0; i < len(results); {
		winning := ""
		for j := 0; j < len(competitions); j++ {
			if results[i] == 1 {
				winning = competitions[j][0]

			} else {
				winning = competitions[j][1]
			}

			final[winning] += 3

			if final[winning] > maxScore {
				maxScore = final[winning]
				winner = winning
			}

			i++
		}
	}

	return winner
}

func main() {

	println(TournamentWinner([][]string{{"HTML", "C#"}, {"C#", "Python"}, {"Python", "HTML"}}, []int{0, 1, 0}))

}
