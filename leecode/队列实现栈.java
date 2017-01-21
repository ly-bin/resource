public class Dequeue {


    public static void main(){

    }

    class MyStack {

        //one Queue solution
        private Deque<Integer> q = new LinkedList<Integer>();

        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            q.pollLast();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }
    }

}
