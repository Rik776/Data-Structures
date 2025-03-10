using System;

namespace carWash
{
    public class Node<T>(T data)
    {
        public T Data { get; } = data;
        public Node<T>? Next { get; set; } = null;
    }
}