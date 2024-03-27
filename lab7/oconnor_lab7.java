import java.util.*;

class oconnor_lab7 
{
    public static void main(String[] args)
    {
        PriorityQueue<VertexWithWeight> p = new PriorityQueue<>(new VertexWithWeightComparator());
       
        VertexWithWeight vww[] = new VertexWithWeight[10];
       
        vww[0] = new VertexWithWeight(0, 0.0);
        vww[1] = new VertexWithWeight(1,1.0);
        vww[2] = new VertexWithWeight(2,2.0);
        vww[3] = new VertexWithWeight(3,3.0);
        vww[4] = new VertexWithWeight(4,4.0);
        vww[5] = new VertexWithWeight(5,0.0);
        vww[6] = new VertexWithWeight(6,1.0);
        vww[7] = new VertexWithWeight(7,2.0);
        vww[8] = new VertexWithWeight(8,3.0);
        vww[9] = new VertexWithWeight(9,4.0);

        for(int i=0; i < vww.length; i++)
        {
            p.add(vww[i]);
        }




        java.util.Iterator iterat = p.iterator();
        while(iterat.hasNext())
        {
            System.out.println(iterat.next());
        }
        System.out.println("");




        //to have p return the array
        vww = p.toArray(new VertexWithWeight[0]);
        for(int i = 0; i < vww.length; i++)
        {
            System.out.println(vww[i]);
        }
        System.out.println("");


        while(p.size() > 0)
        {
            System.out.println("\t" + p.poll());
        }
        System.out.println("");




        //Loop over the original array and add the elements back into the PriorityQueue
        for(int i=0; i < vww.length; i++)
        {
            p.add(vww[i]);
        }

       
        vww[0].setWeight(10.0);
        





        java.util.Iterator iterato = p.iterator();
        while(iterato.hasNext())
        {
            System.out.println(iterato.next());
        }
        System.out.println("");
        






        //Create an array of type VertexWithWeight and print out the elements using the array
        vww = p.toArray(new VertexWithWeight[0]);
        for(int i = 0; i < vww.length; i++)
        {
            System.out.println(vww[i]);
        }
        System.out.println("");





        //Use polling to output the PriorityQueue elements
        while(p.size() > 0)
        {
            System.out.println("\t" + p.poll());
        }
        System.out.println("");
        





        vww[0].setWeight(0.0);

        //Loop over the original array, vww, and add the elements back into the PriorityQueue
        for(int i = 0; i<vww.length; i++)
        {
            p.add(vww[i]);
        }

        //Use p.remove(vww[0]) to delete vww[0] from the PriorityQueue
        p.remove(vww[0]);

        vww[0].setWeight(10.0);

        //Add vww[0] back into p
        p.add(vww[0]);






        //Use polling to output the PriorityQueue elements
        while(p.size() > 0)
        {
            System.out.println("\t" + p.poll());
        }
        System.out.println("");
    }
}