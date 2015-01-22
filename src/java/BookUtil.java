
public class BookUtil {
    private long lb;
    private long mb;
    private long ub;
    private long su;
    private long sl;
    private int seat = 0;
    public BookUtil(long l,long m,long u,long s)
    {
        lb=l;
        mb=m;
        su=s;
        ub=u;
    }
    

    public int BookDef(int pref) {
        int i;
        if (pref == 1) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getLb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 1);
                    } else {
                        setSeat(i * 4);
                    }
                    setLb(setBit(getLb(), i));
                    break;
                }
            }
        }
        else if (pref == 2) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getMb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 2);
                    } else {
                        setSeat(i * 4 + 1);
                    }
                    setMb(setBit(getMb(), i));
                    break;
                }
            }
        }
        else if (pref == 3) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getUb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 3);
                    } else {
                        setSeat(i * 4 + 2);
                    }
                    setUb(setBit(getUb(), i));
                    break;
                }
            }
        }
        else if (pref == 4) {
            for (i = 0; i < 9; i++) {
                int bit = getBit(getSu(), i);
                if (bit == 0) {
                    setSeat(i * 8 + 8);
                    setSu(setBit(getSu(), i));
                    break;
                }
            }
        }
        return getSeat();
    }

     public int Book() {
        int i;
        int pref=1;
        if (pref == 1) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getLb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 1);
                    } else {
                        setSeat(i * 4);
                    }
                    setLb(setBit(getLb(), i));
                    break;
                }
            }
            if (i == 18) {
                pref = 2;
            }
        }
        if (pref == 2) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getMb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 2);
                    } else {
                        setSeat(i * 4 + 1);
                    }
                    setMb(setBit(getMb(), i));
                    break;
                }
            }
            if (i == 18) {
                pref = 3;
            }
        }
        if (pref == 3) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(getUb(), i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        setSeat((i * 4) + 3);
                    } else {
                        setSeat(i * 4 + 2);
                    }
                    setUb(setBit(getUb(), i));
                    break;
                }
            }
            if (i == 18) {
                pref = 4;
            }
        }
        if (pref == 4) {
            for (i = 0; i < 9; i++) {
                int bit = getBit(getSu(), i);
                if (bit == 0) {
                    setSeat(i * 8 + 8);
                    setSu(setBit(getSu(), i));
                    break;
                }
            }
        }
        return getSeat();
    }
    private int getBit(Long number, int bit) {
        long temp = number;
        long op = 1 & (temp >> (bit));
        return (int) op;
    }

    private long setBit(long lb, int i) {
        long temp = lb;
        temp = temp | 1 << i;
        return temp;
    }
    public boolean isLB(int seat)
    {
       seat=seat%8;
        if(seat==1||seat==4)
            return true;
        return false;
    }

    public Long getPnr() {
        return System.currentTimeMillis();
    }

    /**
     * @return the lb
     */
    public long getLb() {
        return lb;
    }

    /**
     * @param lb the lb to set
     */
    public void setLb(long lb) {
        this.lb = lb;
    }

    /**
     * @return the mb
     */
    public long getMb() {
        return mb;
    }

    /**
     * @param mb the mb to set
     */
    public void setMb(long mb) {
        this.mb = mb;
    }

    /**
     * @return the ub
     */
    public long getUb() {
        return ub;
    }

    /**
     * @param ub the ub to set
     */
    public void setUb(long ub) {
        this.ub = ub;
    }

    /**
     * @return the su
     */
    public long getSu() {
        return su;
    }

    /**
     * @param su the su to set
     */
    public void setSu(long su) {
        this.su = su;
    }

    /**
     * @return the sl
     */
    public long getSl() {
        return sl;
    }

    /**
     * @param sl the sl to set
     */
    public void setSl(long sl) {
        this.sl = sl;
    }

    /**
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }
}
