Constructor: The Constructor simply instantiates an instance of the Tree Map saved
             as a Field in this class.

METHODS:
        Get(x): This method returns a string of the distinct values found for each key.
        Since the values saved in this map are of type ArrayLists, a recursive auxiliary
        method is called. This method searches through the ArrayList for repetitive versions
        of the distinct values. It deletes each match ands the distinct value to the
        ArrayList.

        getCount(x): This method returns the number of values within the ArrayList
        that holds the values for a specific keyword.

        keySet(): This method returns a set of all of the keys within the tree map

        put(x, y): This method checks to see if the keyword already exists within the map.
        If the keyword does not exist, the method creates an instance of an ArrayList,
        stores the value passed as a parameter, and adds the key and ArrayList to the
        tree map.
