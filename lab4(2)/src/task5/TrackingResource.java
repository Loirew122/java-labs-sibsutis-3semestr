package task5;
class TrackingResource implements AutoCloseable{
    private final int id;
    private final boolean failOnUse;
    private final boolean failOnClose;

    TrackingResource(int id, boolean failOnUse, boolean failOnClose) {
        this.id = id;
        this.failOnUse = failOnUse;
        this.failOnClose = failOnClose;
        System.out.println("\nOpen : " + id);
    }
    void use(){
        System.out.println("Use : " + id );
        if (failOnUse) throw new IllegalStateException("Use with throw : " + id);
    }
    @Override
    public void close(){
        System.out.println("Close : " + id);
        if (failOnClose) throw new IllegalStateException("Close with throw : " + id);

    }   
    
    
}