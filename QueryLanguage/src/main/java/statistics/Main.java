package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                          .hasAtLeast(10, "goals")
                          .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(60, "points").build();

        Matcher m3 = query.oneOf(m1, m2).build();        
        
        for (Player player : stats.matches(m1)) {
            System.out.println( player );
        }
        System.out.println("\n*******\n");
        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        }
        System.out.println("\n*******\n");
        for (Player player : stats.matches(m3)) {
            System.out.println( player );
        }
        System.out.println("\n*******\n");
        
//        m = new And( new HasFewerThan(10, "goals"),
//                             new HasFewerThan(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        System.out.println("\n*******\n");
//        
//        m = new Or( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        System.out.println("\n*******\n");
//        
//        m = new Not(new Or( new HasAtLeast(10, "goals"),
//                             new HasAtLeast(10, "assists"),
//                             new PlaysIn("PHI")
//        ));
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
    }
}
