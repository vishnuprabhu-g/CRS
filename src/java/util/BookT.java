/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author vishnu-pt517
 */
public class BookT {

    public long lb;
    public long mb;
    public long ub;
    public long su;
    public long sl;
    int seat = 0;

    public BookT(long l, long m, long u, long s) {
        lb = l;
        mb = m;
        su = s;
        ub = u;
    }

    public int BookDef(int pref) {
        int i;
        if (pref == 1) {
            for (i = 0; i < 4; i++) {
                int bit = getBit(lb, i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        seat = ((i * 4) + 1);
                    } else {
                        seat = (i * 4);
                    }
                    lb = (setBit(lb, i));
                    break;
                }
            }
        } else if (pref == 2) {
            for (i = 0; i < 4; i++) {
                int bit = getBit(mb, i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        seat = ((i * 4) + 2);
                    } else {
                        seat = (i * 4 + 1);
                    }
                    mb = (setBit(mb, i));
                    break;
                }
            }
        } else if (pref == 3) {
            for (i = 0; i < 18; i++) {
                int bit = getBit(ub, i);
                if (bit == 0) {
                    if (i % 2 == 0) {
                        seat = ((i * 4) + 3);
                    } else {
                        seat = (i * 4 + 2);
                    }
                    ub = (setBit(ub, i));
                    break;
                }
            }
        } else if (pref == 4) {
            for (i = 0; i < 9; i++) {
                int bit = getBit(su, i);
                if (bit == 0) {
                    seat = (i * 8 + 8);
                    su = (setBit(su, i));
                    break;
                }
            }
        }
        return seat;
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
}
