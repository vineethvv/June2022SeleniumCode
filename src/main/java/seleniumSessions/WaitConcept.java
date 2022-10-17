package seleniumSessions;

public class WaitConcept {

	public static void main(String[] args) {
		
		
		//wait: sync
		
		//Thread.sleep -----> Means pausing the script , if you applies wait for 10sec & if the element appears in 2 sec, it wait for the remaining 8 sec.
		
		//1. //static wait: Thread.sleep(10000); -- 2 secs --> 10 secs -- java
		
		//2. //Dynamic wait ---> if you applies wait for 10sec & if the element appears in 2 sec, it will ingnore/cancel the remaining 8 sec.
		
		//dynamic wait: 10 --> 2 secs ---> 8 secs will be cancelled
				
			//2A. //implicitly wait
			//2B. //explicit wait
					//2B1. webdriverwait
					//2B2. fluentwait
				
				//selenium script ---> browser --- app

	}

}
