/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author suses
 */
public class BFS_DFS {
    
    
    static void DFS(int[][] graph,int start_node){
        int node_count=graph[0].length;
        int[] visit=new int[]{0,0,0,0};
        Stack S=new Stack();
        
        S.push(start_node);
        start_node = (int) S.pop();
        visit[start_node]=1;
        System.out.println(start_node);
        
        while (true){
        
        
            for(int i=0;i<node_count;i++){
            
                if(graph[start_node][i]==1 && visit[i]==0){
                    
                    visit[i]=1;
                    S.push(i);
                
                
                }
                
                
            
            }
            if(S.isEmpty()==true){ //If we traverse all elements of graph stack will be empty and out job ıs done
                 break;
                
                }
            else{
                 int a= (int)S.capacity()-1;
                 start_node = (int) S.peek();  //Peek a vertex from stack to visit next
                 S.pop(); //remove an element from stack
                 System.out.println(start_node);
                
                }
        
        }
        
        
        
        
    }

    static void BFS(int[][] graph,int start_node){ //BFS suitable for Shortest path algorithms and it uses Queue (DFS uses Stack)
        int node_count=graph[0].length;
        int[] visit=new int[]{0,0,0,0};
        Queue Q = new LinkedList();
        
        Q.add(start_node);//start node changes to the other nodes to traversal 
        start_node = (int)Q.poll();
        visit[start_node]=1;
        System.out.println(start_node);
        
        while(true){
            for(int i=0;i<node_count;i++){

                if( graph[start_node][i]==1 && visit[i]==0 ){ //if start_nodeth element and i. element has connection and i. element did not visited yet.

                     Q.add(i); //add vertes to queue
                     visit[i]=1; //mark as visited

                }
                
            }
            
            if(Q.isEmpty()==true){
                break;
            }
            else{
                
                start_node = (int)Q.poll();//start node changes to the other nodes to traversal
                
                System.out.println(start_node); //show vertex
            
            }
        
        }
        
        
        
    }
    
    public static void main(String[] args) {
        
        int[][] graph=new int[][]{ {0,1,1,0},
                                   {0,0,1,0},
                                   {1,0,0,1},
                                   {0,0,0,1}
         };
        
        System.out.println("BFS traversal of the graph");
        BFS(graph,2);
        System.out.println("---------------------------");
        System.out.println("DFS traversal of the graph");
        DFS(graph,0);
        
        
    }
    
}
