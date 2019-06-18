package labs.prob2;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondLargest {
	//Fix this code
	public static List<Integer> getTestList() {
	    return Stream.generate(Math::random)
	        .map(val->new Double(val*200).intValue()).limit(10)
	        .collect(Collectors.toList());
	}
	
	/**
	 * Retrieves the second largest element using natural order search
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<T>> Optional<? extends T> getSecondLargest(List<? extends T> list) { 
	    return list.stream()
	        .sorted()      // since T extends comparable, sorted is sufficient for sorting
	        .skip(1)          // skip first element to get to the send largest.
	        .findFirst();
	}
	
	//Test using this main method
	public static void main(String[] args) {
		List<Integer> intValues = getTestList();
		System.out.println("Using list: " + intValues);
		System.out.println("second largest integer is: " + getSecondLargest(intValues).get());
		System.out.println();
		
		List<LocalDate> dates = Arrays.asList(LocalDate.now(), LocalDate.now().minusDays(10), 
		    LocalDate.now().minusDays(5), LocalDate.now().minusDays(7));
        System.out.println("Using date list: " + dates);
        System.out.println("second largest date is: " + getSecondLargest(dates).get());
        System.out.println();
        
	}
}
