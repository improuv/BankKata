package acceptance;

import com.improuv.Account;
import com.improuv.Console;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class PrintStatementFeature {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock Console console;

	private Account account;

	@Before
	public void init() {
		account = new Account();
	}

	@Test public void
	printStatementShouldContainAllTransactions() {
		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);

		account.printStatement();

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}
}
