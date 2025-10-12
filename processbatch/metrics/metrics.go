package metrics

type MetricCollector interface {
	// RecordCounter increments a counter metric by a specific value (value is typically 1).
	RecordCounter(name string, value float64, labels map[string]string)

	// RecordGauge sets a gauge metric to a specific value,
	// typically used for current state/size/memory.
	RecordGauge(name string, value float64, labels map[string]string)

	// RecordHistogram observes a value for a histogram metric,
	// typically used for latency.
	RecordHistogram(name string, value float64, labels map[string]string)
}

type MockMetricCollector struct{}

func (m *MockMetricCollector) RecordCounter(name string, value float64, labels map[string]string) {
	println("Counter:", name, "Value:", value)
	for k, v := range labels {
		println(" -", k+":", v)
	}
}

func (m *MockMetricCollector) RecordGauge(name string, value float64, labels map[string]string) {
	println("Gauge:", name, "Value:", value)
	for k, v := range labels {
		println(" -", k+":", v)
	}
}

func (m *MockMetricCollector) RecordHistogram(name string, value float64, labels map[string]string) {
	println("Histogram:", name, "Value:", value)
	for k, v := range labels {
		println(" -", k+":", v)
	}
}
