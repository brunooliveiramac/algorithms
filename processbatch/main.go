package main

import (
	"fmt"
	"processbatch/metrics"
	"processbatch/processor"
)

func ProcessBatch(records []processor.Record, store processor.DataStore, collector metrics.MetricCollector) (totalProcessed int) {

	groups := make(map[int][]processor.Record)
	for _, record := range records {
		groupID := record.GroupID

		_, ok := groups[groupID]
		if ok {
			myListGroup := groups[groupID]
			myListGroup = append(myListGroup, record)
			groups[groupID] = myListGroup
		} else {
			var myListGroup []processor.Record
			myListGroup = append(myListGroup, record)
			groups[groupID] = myListGroup
		}
	}

	for key, value := range groups {
		fmt.Printf("Key: %s, Value: %d\n", key, value)
		if err := store.UpdateRecords(value); err == nil {
			totalProcessed += len(value)
		}
	}

	return totalProcessed
}

//func ProcessBatch(records []processor.Record, store processor.DataStore, collector metrics.MetricCollector) (totalProcessed int) {
//
//	processedGroups := make([]int, 0)
//
//	for i := range records {
//		record := records[i]
//		groupID := record.GroupID
//
//		// Check if group has already been processed
//		isProcessed := false
//		for _, gID := range processedGroups {
//			if gID == groupID {
//				isProcessed = true
//				break
//			}
//		}
//
//		if !isProcessed {
//			// Create a new list for the current group
//			groupList := make([]processor.Record, 0)
//			for j := range records {
//				if records[j].GroupID == groupID {
//					groupList = append(groupList, records[j])
//				}
//			}
//
//			// The UpdateRecords method can only update records of the same group
//			if err := store.UpdateRecords(groupList); err == nil {
//				processedGroups = append(processedGroups, groupID)
//				totalProcessed += len(groupList)
//			}
//		}
//	}
//
//	return totalProcessed
//}

func main() {
	// Example usage
	records := []processor.Record{
		{ID: "1", GroupID: 1, Status: "new", Payload: map[string]interface{}{"data": "record1"}},
		{ID: "2", GroupID: 1, Status: "new", Payload: map[string]interface{}{"data": "record2"}},
		{ID: "3", GroupID: 2, Status: "new", Payload: map[string]interface{}{"data": "record3"}},
		{ID: "4", GroupID: 2, Status: "new", Payload: map[string]interface{}{"data": "record4"}},
		{ID: "5", GroupID: 3, Status: "new", Payload: map[string]interface{}{"data": "record5"}},
	}

	var store processor.DataStore = &processor.MockDataStore{}
	var collector metrics.MetricCollector = &metrics.MockMetricCollector{}

	total := ProcessBatch(records, store, collector)
	println("Total processed records:", total)
}
