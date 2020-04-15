package Creational.d_Singleton.h_TestabilityIssues;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import com.google.common.collect.Iterables;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


class SingletonDatabase {
    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanctCount = 0;

    public static int getCount() {
        return instanctCount;
    }

    private SingletonDatabase() {
        instanctCount++;
        System.out.println("Initializing database.");

        try {
            File f = new File(
                    SingletonDatabase.class.getProtectionDomain()
                            .getCodeSource().getLocation().getPath()
            );
            Path fullPath = Paths.get(
            "src/Creational/d_Singleton/h_TestabilityIssues/capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);

            Iterables.partition(lines, 2)
                    .forEach(kv -> capitals.put(
                            kv.get(0).trim(),
                            Integer.parseInt(kv.get(1))
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final SingletonDatabase INSTANCE
            = new SingletonDatabase();

    public static SingletonDatabase getInstance() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }
}

class SingletonRecordFinder {
    public int getTotalPopulation(List<String> cityNames) {
        int result = 0;
        for (String name : cityNames)
            result += SingletonDatabase.getInstance().getPopulation(name);
        return result;
    }
}

public class Tests {
    @Test
    public void singletonTotalPopulationTest() {
        SingletonRecordFinder rf = new SingletonRecordFinder();
        List<String> names = List.of("Seoul", "Mexico City");
        int tp = rf.getTotalPopulation(names);
        assertEquals(17_500_000+17_400_000, tp);
    }
}
