package main

/*
 * Complete the 'weatherStation' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING keyword as parameter.
 *
 * Base URL: https://jsonmock.hackerrank.com/api/weather/search?name={keyword}
 *
 */

import (
	"bufio"
	"encoding/json"
	_ "encoding/json"
	"fmt"
	"io"
	"net/http"
	_ "net/http"
	"net/url"
	"os"
	"regexp"
	"strings"
	"time"
)

type row struct {
	name string
	line []string
}

type Response struct {
	Page       int       `json:"page"`
	PerPage    int       `json:"per_page"`
	Total      int       `json:"total"`
	TotalPages int       `json:"total_pages"`
	Data       []cityRec `json:"data"`
}

type cityRec struct {
	Name    string   `json:"name"`
	Weather string   `json:"weather"`
	Status  []string `json:"status"`
}

var numRe = regexp.MustCompile(`\d+`)

func firstInt(s string) string {
	m := numRe.FindString(s)
	if m == "" {
		return "0"
	}
	return m
}

func weatherStation(keyword string) []string {
	base := "https://jsonmock.hackerrank.com/api/weather/search?name="
	esc := url.QueryEscape(keyword)
	client := &http.Client{Timeout: 10 * time.Second}

	page := 1

	var rows []row

	for {
		reqUrl := base + esc + "&page=" + fmt.Sprintf("%d", page)
		resp, err := client.Get(reqUrl)
		if err != nil {
			break
		}
		defer resp.Body.Close()

		var apiResp Response
		err = json.NewDecoder(resp.Body).Decode(&apiResp)
		if err != nil {
			break
		}

		for _, city := range apiResp.Data {
			weather := firstInt(city.Weather)
			wind := "0"
			humidity := "0"

			for _, status := range city.Status {
				ls := strings.ToLower(status)
				if strings.HasPrefix(ls, "wind") {
					wind = firstInt(ls)
				} else if strings.HasPrefix(ls, "humidity") {
					humidity = firstInt(ls)
				}
			}
			rows = append(rows, row{
				name: city.Name,
				line: []string{city.Name, weather, wind, humidity},
			})
		}

		if page >= apiResp.TotalPages || apiResp.TotalPages == 0 {
			break
		}
		page++

	}
	sort.Slice(rows, func(i, j int) bool { return rows[i].name < rows[j].name })

	out := make([]string, len(rows))
	for i, r := range rows {
		out[i] = strings.Join(r.line, ",")
	}
	return out
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	keyword := readLine(reader)

	result := weatherStation(keyword)

	for i, resultItem := range result {
		fmt.Fprintf(writer, "%s", resultItem)

		if i != len(result)-1 {
			fmt.Fprintf(writer, "\n")
		}
	}

	fmt.Fprintf(writer, "\n")

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
