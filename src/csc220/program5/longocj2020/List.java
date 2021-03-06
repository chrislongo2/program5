//Chris Longo
//5/3/17
//Program 5 - List


package csc220.program5.longocj2020;

import csc220.list.AddIterator;
import csc220.list.Node;

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
            Node<E> tmp = new Node<>();
            tmp.data = e;
            
            if (nextNode != null) {
                
                //If at the beginning
                if(first == nextNode){   
                    first.next = tmp;
                    tmp.next = nextNode;
                }//else in between
                else{ 
                    prevNode.next = tmp; 
                    tmp.next = nextNode;
                }
            }else{ //else last 
                prevNode.next = tmp;
                tmp.next = nextNode;
            }
        }
        
        @Override
        public void remove() { 
            
            if(prevNode == null){
                throw new IllegalStateException();
            }
            
            if (prevNode == first) {
                first = nextNode;  
            }else{
                Node<E> tmp = first;
                    while (tmp.next != prevNode) {
                        tmp = tmp.next;
                    }
                tmp.next = nextNode;
            }
            
            if(prevNode == last){ 
                last = prevNode;
            }
            
            prevNode = null;
 
        }

     }
   
   
}
