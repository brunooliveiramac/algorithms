HOME_TEAM_WON = 1


def updateScores(winningTeam, score, scores):
    # just for initializing this item as 0 to sum after
    if winningTeam not in scores:
        scores[winningTeam] = 0
    scores[winningTeam] += score


def tournamentWinner(competitions, results):
    currentBestTeam = ""
    scores = {currentBestTeam: 0}

    for index, competition in enumerate(competitions):
        result = results[index]
        homeTeam, awayTeam = competition

        winningTeam = homeTeam if result == HOME_TEAM_WON else awayTeam

        updateScores(winningTeam, 3, scores)

        if scores[winningTeam] > scores[currentBestTeam]:
            currentBestTeam = winningTeam

    return currentBestTeam


if __name__ == '__main__':

    # [homeTeam, awayTeam]
    competitions = [
        ["HTML", "C#"],
        ["C#", "Python"],
        ["Python", "HTML"]
    ]

    # 0 means the away team won.
    # 1 mean the home team won.
    results = [0, 0, 1]
    # 3 points if wins and 0 if it loses.

    print(tournamentWinner(competitions, results))
