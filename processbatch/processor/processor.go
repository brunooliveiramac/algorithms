package processor

type Record struct {
	ID      string
	GroupID int // Identifies the group this record belongs to.
	Status  string
	Payload map[string]interface{}
}

type DataStore interface {
	// Udpates a list of records of the same group.
	// It must be called only once per unique GroupID.
	UpdateRecords(records []Record) error
}

type MockDataStore struct{}

func (m *MockDataStore) UpdateRecords(records []Record) error {
	// Mock implementation: just print the records being updated
	println("Updating records for GroupID:", records[0].GroupID)
	for _, record := range records {
		println(" - Record ID:", record.ID, "Status:", record.Status)
	}
	return nil
}
