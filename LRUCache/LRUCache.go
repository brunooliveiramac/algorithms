package main

type LRUCache struct {
	Capacity  int
	Cache     map[int]Node
	NodeLeft  Node
	NodeRight Node
}

type Node struct {
	Key      int
	Value    int
	Next     *Node
	Previous *Node
}

func Constructor(capacity int) LRUCache {
	cache := LRUCache{Capacity: capacity, Cache: make(map[int]Node)}
	nodeLeft := Node{Key: -1, Value: -1, Next: nil, Previous: nil}
	nodeRight := Node{Key: -1, Value: -1, Next: nil, Previous: nil}

	nodeLeft.Next = &nodeRight
	nodeRight.Previous = &nodeLeft

	cache.NodeLeft = nodeLeft
	cache.NodeRight = nodeRight
	return cache
}

func (this *LRUCache) RemoveNode(node *Node) {
	node.Previous.Next = node.Next
	node.Next.Previous = node.Previous
}

// insert at right
func (this *LRUCache) AddNode(node *Node) {
	node.Previous = this.NodeRight.Previous
	node.Next = &this.NodeRight
	this.NodeRight.Previous.Next = node
	this.NodeRight.Previous = node
}

func (this *LRUCache) Get(key int) int {
	if _, ok := this.Cache[key]; ok {
		node := this.Cache[key]
		this.RemoveNode(&node) // remove from current position
		this.AddNode(&node)    // add to most recent used
		return node.Value
	} else {
		return -1
	}
}

func (this *LRUCache) Put(key int, value int) {
	if k, ok := this.Cache[key]; ok {
		this.RemoveNode(&k) // remove from current position
		this.AddNode(&k)    // add to most recent used
		this.Cache[key] = Node{
			Key:   key,
			Value: value,
		}
		n := this.Cache[key]
		this.AddNode(&n)
		if len(this.Cache) > this.Capacity {
			// remove the LRU
			lru := this.NodeLeft.Next
			this.RemoveNode(lru)
			delete(this.Cache, lru.Key)
		}

	}
}

func main() {

}
