package com.deedee.thelemia.graphics.enumerate;

public enum Easing {
    LINEAR {
        @Override
        public float apply(float t) {
            return t;
        }
    },
    EASE_IN_QUAD {
        @Override
        public float apply(float t) {
            return t * t;
        }
    },
    EASE_OUT_QUAD {
        @Override
        public float apply(float t) {
            return t * (2 - t);
        }
    },
    EASE_IN_OUT {
        @Override
        public float apply(float t) {
            if (t < 0.5f) return 2f * t * t;
            return -1f + (4f - 2f * t) * t;
        }
    };

    public abstract float apply(float t);
}
