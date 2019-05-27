package rle_tests;

import static org.junit.Assert.assertEquals;

import module6.codec_rle.CodecRLE;
import org.junit.Assert;
import org.junit.Test;

public class RLETest {

    @Test
    public void coded1(){
        assertEquals("4A3a6B///1/2", CodecRLE.code("AAAAaaaBBBBBB/12"));
    }

    @Test
    public void coded2(){
        assertEquals("1A3a2B/2",CodecRLE.code("AaaaBB2"));
    }

    @Test
    public void coded3(){
        assertEquals("1A3a2B/////2",CodecRLE.code("AaaaBB//2"));
    }

    @Test
    public void decoded1(){
        assertEquals("AAAAaaaBBBBBB/12",CodecRLE.decode("4A3a6B///1/2"));
    }

    @Test
    public void decoded2(){
        assertEquals("AaaaBB2",CodecRLE.decode("1A3a2B/2"));
    }

    @Test
    public void decoded3(){
        assertEquals("AaaaBB//2",CodecRLE.decode("1A3a2B/////2"));
    }
}
