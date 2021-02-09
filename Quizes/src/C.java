static class C1 {
    int getValue1() {return 1;};
}
static class C2 extends C1 {
    int getValue1() {return super.getValue1() + 5;}
}
static class C3 extends C2 {
    @Override
    public int getValue1() {
        return 3 + super.getValue1();
    }
}
