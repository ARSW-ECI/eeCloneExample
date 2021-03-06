package edu.bsu.cs639.eeclone.audio;

import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;

public final class SoundManagerFactory {

  private static final int DEFAULT_MAX_SIMULTANEOUS = 8;
  
  private static final SoundManagerFactory SINGLETON = new SoundManagerFactory();
  
  public static SoundManagerFactory instance() { return SINGLETON; }
  
  /** Max simultaneous sounds */
  private int maxSimultaneous = DEFAULT_MAX_SIMULTANEOUS;
  
  private Map<AudioFormat,SoundManager> map
    = new HashMap<AudioFormat, SoundManager>();
  
  public SoundManager get(AudioFormat format) {
    assert format!=null;
    SoundManager sm = map.get(format);
    if (sm==null) {
      sm = new SoundManager(format, maxSimultaneous);
      map.put(format,sm);
    }
    return sm;
  }
  
  /**
   * Change the max number of simultaneous sounds supported by sound managers
   * generated by this factory
   * @param max 
   */
  public void setMaxSimultaneousSounds(int max) {
    this.maxSimultaneous = max;
  }
  
}
