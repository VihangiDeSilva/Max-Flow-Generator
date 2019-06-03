// w1701073_2017405_Vihangi_Dharmawickrama Java program for implementation of the maximum flow network using Ford-Fulkerson Algorithm

import java.util.Scanner;
public class mainMF {

    public static void main(String[] args) {

        // initialize the Scanner
        Scanner myInput = new Scanner(System.in);

        //create a object from maximumFlow
        maximumFlow obj = new maximumFlow();

        //creating variables
        int capacity;
        int nodes;
        int maxNodes = 10;
        int minNodes = 6;
        int maxCap = 20;
        int minCap = 5;



        System.out.println("Select your preferences : \n 1.Enter 1 for Input values and find maximum flow network " +
                "\n 2.Enter 2 for Generate maximum flow network randomly ");
        int userChoise = myInput.nextInt();

        if (userChoise == 1) {
            System.out.println("please enter the number of nodes(between 4 and 10) : ");
            nodes = myInput.nextInt();

            if (nodes < 4 || nodes > 10) {
                System.err.println("Error!!! The number of nodes that you entered must be between 4 to 10!!");
            }
                int[] myArray1 = new int[nodes];
                int[][] myArray2 = new int[nodes][nodes];
                for (int i = 0; i < myArray1.length; i++) {
                    for (int j = 0; j < myArray2.length; j++) {

                        System.out.println("Enter value for capacity : ");
                        int inputCap = myInput.nextInt();
                        if(inputCap <5 || inputCap>20){
                            System.err.println("Error!!! capacity should be between 5 and 20!!!");
                        }

                        capacity = inputCap;
                        myArray1[j] = capacity;

                    }
                    myArray2[i] = myArray1.clone();
                }

                System.out.println("The maximum possible flow is " + obj.fordFulkerson(myArray2, 0, 5));


            } else {

                int nodeRange = maxNodes - minNodes + 1;
                nodes = (int) (Math.random() * nodeRange) + minNodes;
                System.out.println(nodes);

                int[] myArray1 = new int[nodes];
                int[][] myArray2 = new int[nodes][nodes];
                for (int i = 0; i < myArray1.length; i++) {
                    for (int j = 0; j < myArray2.length; j++) {

                        int capRange = maxCap - minCap + 1;
                        capacity = (int) (Math.random() * capRange) + minCap;
                        myArray1[j] = capacity;

                    }

                    myArray2[i] = myArray1.clone();

                }

                System.out.println("The maximum possible flow is " + obj.fordFulkerson(myArray2, 0, 5));


                for(int i = 0; i < myArray2.length; i++)   // for print the array
                {
                    for(int j = 0; j < myArray2[i].length; j++)
                    {
                        System.out.printf("%5d ", myArray2[i][j]);
                    }
                    System.out.println();

            }

            }


        }


    }
