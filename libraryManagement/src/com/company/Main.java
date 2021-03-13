package com.company;

import entity.Librarian;
import entity.Library;
import entity.Rack;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Library library = generateLibrary();
        Librarian librarian = new Librarian();


    }

    private static Library generateLibrary() {
        String libraryName = "Vineeth's library";
        Integer maxNBooksPerUser = 5;
        Integer maxDaysPerBook = 10;
        List<Rack> rackList = generateRackList();
        return new Library(libraryName, maxNBooksPerUser, maxDaysPerBook, rackList);
    }

    private static List<Rack> generateRackList() {
        Rack rack1 = new Rack("Rack 1");
        Rack rack2 = new Rack("Rack 2");
        Rack rack3 = new Rack("Rack 3");
        return Arrays.asList(rack1, rack2, rack3);
    }
}
