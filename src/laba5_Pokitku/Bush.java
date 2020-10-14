package laba5_Pokitku;

public class Bush extends Plant{
    private static int count = 0;

    public static int getCount() { return count; }

    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) throws IllegalArgumentException {
        if (!(month.equalsIgnoreCase("январь")||month.equalsIgnoreCase("февраль")||
                month.equalsIgnoreCase("март")||month.equalsIgnoreCase("апрель")||
                month.equalsIgnoreCase("май")||month.equalsIgnoreCase("июнь")||
                month.equalsIgnoreCase("август")||month.equalsIgnoreCase("сентябрь")||
                month.equalsIgnoreCase("октябрь")||month.equalsIgnoreCase("ноябрь")||
                month.equalsIgnoreCase("декабрь")||month.equalsIgnoreCase("июль"))) {
            throw new IllegalArgumentException("Введен неправильный месяц цветения!");
        }
        this.month = month;
    }

    public Bush(String name, String month) throws IllegalArgumentException{
        super(name);
        this.setMonth(month);
        count++;
    }

    @Override
    public String info() {
        return super.info() + ", тип - кустарник, месяц цветения - " + this.month;
    }
}