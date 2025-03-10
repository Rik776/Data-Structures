using System;

namespace carWash
{
    public class Queue<T>
    {
        private Node<T>? head;
        private Node<T>? tail;
        private int size;

        public int Size => size;
        public bool IsEmpty => size == 0;
        public Queue()
        {
            head = null;
            tail = null;
            size = 0;
        }

        public void Add(T data)
        {
            Node<T> newNode = new Node<T>(data);
            if(IsEmpty)
            {
                head = newNode;
            }
            else
            {
                tail.Next = newNode;
            }
            tail = newNode;
            size++;
        }

        public T GetValue()
            {
            if (IsEmpty )
            {
                throw new InvalidOperationException("La cola está vacía");
            } 
            return head.Data;
            }
        public T pullValue()
        {
            if (IsEmpty)
            {
                throw new InvalidOperationException("La cola está vacía");
            } 

            T aux = head.Data;
            head = head.Next;
            if (head == null)
            {
                tail = null;
            }
            size--;
            return aux;
        }
        public void clear()
        {
            head = null;
            tail = null;
            size = 0;
        }
    }
}