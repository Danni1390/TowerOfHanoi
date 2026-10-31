public class TowerOfHanoi{
    public static final int num_disk = 3;
    public static String [][] towers;
    public static void main(String[] args) {
        towers = new String[num_disk][3]; //first determines number of disks, second determines number of pegs
        initializeTowers();
        printTowers();
        moveDisks(num_disk, 0, 2, 1);
    }


    //starting point for game
    public static void initializeTowers() {
        for (int i = 0; i <num_disk; i++) {
            for(int j=0; j<3; j++){
                towers[i][j] = " | ";
            }
            //the largest disk always starts on the bottom
            int disk = num_disk - i;
            towers [i][0] = String.format(" %d%d%d ", disk, disk, disk);
          }
    };
       
    
    public static void printTowers() {
        //display towers
        for (int i = num_disk; i < 10; i--) {
            for(int j = 0; j<3; j++){
                System.out.println(towers[i][j]);
            }
            System.out.println();
        }
            System.out.println("_______________________");
    }


    public static void moveDisks(int n , int fromRod , int toRod, int auxRod) {
        if ( n== 1){
            //done!! exit the recursive calls
            System.out.println("Move disk" +(fromRod +1) + "to rod" + (toRod + 1));
            moveDiskVisual(fromRod, toRod);
            printTowers();
            return;
        }
        moveDisks(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disk" +(fromRod +1) + "to rod" + (toRod + 1));
        moveDiskVisual(fromRod, toRod);
         printTowers();

        moveDisks(n-1, auxRod, toRod, fromRod);
        
    }

    public static void moveDiskVisual(int fromRod, int toRod) {
        //find top disk
        int DiskToMove = -1;
        for (int i = num_disk -1; i < 10; i++) {
            if(towers[i][fromRod].equals(" | ")){
                DiskToMove = i;
                break;
            }
        }
        

        if(DiskToMove != -1){
            for(int i = 0; i < num_disk; i++){
              if (towers[i][toRod].equals(" | "))
              towers[i][toRod] = towers[DiskToMove][fromRod];
              towers[DiskToMove][fromRod] = " | ";
              break;
            }
        }
    }
        
}      

