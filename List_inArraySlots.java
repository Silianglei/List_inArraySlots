/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    // declare fields here
    int[] refArray;
    int filledElements;
    /**
      Construct an empty list with a small initial capacity.
      int
     */
    public List_inArraySlots() {
      refArray = new int[10];
      filledElements = 0;
    }


    /**
      @return the number of elements in this list
     */
     public int size() {
     return refArray.length;
     }

     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
      String s = "[";
    for(int index = 0; index < this.size(); index ++ ) {
      s = s + refArray[index] + System.lineSeparator() ;
    }
    s += "]";
    return s;
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int value) {
       if (filledElements < this.size()) {
       refArray[filledElements++] = value;
     }
     else {
        this.expand();
        refArray[filledElements++] = value;

      }

       return true;
      }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data
     */
    private void expand() {
        // System.out.println( "expand... (for debugging)");
           // /* S.O.P. rules for debugging:
              // Working methods should be silent. But during
              // development, the programmer must verify that
              // this method is called when that is appropriate.
              // So test using the println(), then comment it out.
              // */
              int[] oldArray = new int[filledElements];
              refArray = oldArray;
              refArray = new int[2 * filledElements];
              for(int index = 0; index < filledElements; index++) {
                refArray[index] = oldArray[index];
              }
   }

   /**
     accessor
     @return element @index from this list
     precondition: @index is within the bounds of the array.
         (Having warned the user about this precondition,
          you should NOT complicate your code to check
          whether user violated the condition.)
    */
   public int get( int index ) {
     return refArray[index];
   }


   /**
     Set value at @index to @newValue

     @return old value at @index
     @precondition: @index is within the bounds of this list.
    */
   public int set( int index, int newValue ) {
     int oldValue = refArray[index];
     refArray[index]= newValue;
     return oldValue;
   }


   /**
     Insert @value at position @index in this list.

     Shift the element currently at that position (if any)
     and any subsequent elements to the right
     (that is, increase the index associated with each).
    */
    public void add( int index, int value) {
      for(int num = filledElements; num > index; num--){
      refArray[num] = refArray[num - 1];
    }
      set(index, value);
      filledElements++;
    }


   /**
     Remove the element at position @index in this list.

     Shift any subsequent elements to the left (that is,
     decrease the index associated with each).

     @return the value that was removed from the list
    */
    public int remove( int index) {
      int oldValue = refArray[index];
      for(int num = index; num < filledElements - 1; num++){
      refArray[num] = refArray[num + 1];
    }
      refArray[filledElements--] = 0;
      return oldValue;
    }
}
