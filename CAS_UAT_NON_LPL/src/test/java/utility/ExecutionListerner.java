package utility;

import org.testng.IExecutionListener;

import UAT_CAS_Other_than__LPL.Emailsend;

public class ExecutionListerner implements IExecutionListener{
private long startTime;
	
	@Override
	public void onExecutionStart() {
	startTime = System.currentTimeMillis();
	System.out.println("Start Time is " +startTime+ " miliseconds");
		
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("Test classes have been executed and Email is sending");	
		Emailsend.main(null);
		
	}

	
	
}
