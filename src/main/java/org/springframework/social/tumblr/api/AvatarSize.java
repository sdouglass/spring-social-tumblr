package org.springframework.social.tumblr.api;

public enum AvatarSize {

    /**
     * 16px x 16px
     */
    PICO(16),

    /**
     * 24px x 24px
     */
    NANO(24),

    /**
     * 30px x 30px
     */
    MICRO(30),

    /**
     * 40px x 40px
     */
    TINY(40),

    /**
     * 48px x 48px
     */
    SMALL(48),

    /**
     * 64px x 64px
     */
    NORMAL(64),

    /**
     * 96px x 96px
     */
    LARGE(96),

    /**
     * 128px x 128px
     */
    MEGA(128),

    /**
     * 512 x 512
     */
    GIGA(512);

    private int dimension;

    AvatarSize(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return this.dimension;
    }
}
