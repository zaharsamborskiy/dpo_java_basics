import java.util.Map;

public class Main
{
    public static void main(String[] args) {
        Bank bank = new Bank();
        Map<String, Account> accountMap = bank.account();
        System.out.println("Сумма на банковском счете ->->->->-> " + bank.getSumAllAccounts());
        for (int i = 0; i <= 10; i++)
        {
            Thread thread = new Thread(() ->
            {
                try
                {
                    for (int j = 0; j <= 100; j++)
                    {
                        String from = accountMap.get(createrNumber()).getAccNumber();
                        String to = accountMap.get(createrNumber()).getAccNumber();
                        int money = createrMoney();
                        bank.transfer(from, to, money);
                    }
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }

    public static String createrNumber()
    {
        int value = (int) ( 1 + Math.random() * 100);
        String valueS = "A"+ value;
        return valueS;
    }
    public static Integer createrMoney()
    {
        int value = (int) (1 + Math.random() * 100_000);
        return value;
    }
}
