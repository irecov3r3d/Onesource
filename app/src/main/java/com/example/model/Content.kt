package com.example.model

data class Chapter(
    val id: String,
    val title: String,
    val subtitle: String,
    val biblicalAnchor: String? = null,
    val keyTerms: List<Pair<String, String>> = emptyList(),
    val sections: List<Section> = emptyList(),
    val practices: List<String> = emptyList(),
    val summary: String? = null
)

data class Section(
    val title: String,
    val content: String
)

data class Appendix(
    val id: String,
    val title: String,
    val content: String,
    val items: List<String> = emptyList()
)

val Chapters = listOf(
    Chapter(
        id = "ch1",
        title = "CHAPTER ONE — THE ROOT CENTER (MALKUTH)",
        subtitle = "Foundation, Grounding, Embodiment",
        biblicalAnchor = "“The LORD God formed the human from the dust of the ground and breathed into the nostrils the breath of life.” — Genesis 2:7",
        keyTerms = listOf(
            "Adamah" to "ground, earth, soil",
            "Adam" to "human",
            "Afar" to "dust",
            "Neshimah" to "breath"
        ),
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Malkuth and the Shekhinah",
                "Malkuth is the tenth sefirah, the realm of manifestation. It is the dwelling place of the Shekhinah, the divine presence in matter. The work of the Root is not transcendence but sanctification of the physical."
            ),
            Section(
                "Scientific Correlation — The HPA Axis",
                "The Root corresponds to the adrenal system and the body’s survival circuitry. Chronic stress dysregulates this axis, making spiritual ascent biologically impossible."
            )
        ),
        practices = listOf(
            "Morning gratitude (Modeh Ani)",
            "Barefoot earth contact",
            "Somatic grounding",
            "Honest engagement with physical needs"
        ),
        summary = "The Root teaches that embodiment is not a limitation but the beginning of spiritual life."
    ),
    Chapter(
        id = "ch2",
        title = "CHAPTER TWO — THE SACRAL CENTER (YESOD)",
        subtitle = "Creativity, Flow, Emotional Fluidity",
        biblicalAnchor = "“Out of the belly shall flow rivers of living water.” — John 7:38",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Yesod",
                "Yesod is the channel through which all higher energies flow into physical reality. It is the foundation of generative power."
            ),
            Section(
                "Scientific Correlation — The Enteric Nervous System",
                "The gut contains 500 million neurons and produces 95% of the body’s serotonin. Emotional adaptability and creative flow are biologically rooted here."
            )
        ),
        practices = listOf(
            "Breathwork focused on the lower abdomen",
            "Emotional fluidity exercises",
            "Creative expression",
            "Release of shame and suppression"
        ),
        summary = "The Sacral Center is the river of life within the human vessel."
    ),
    Chapter(
        id = "ch3",
        title = "CHAPTER THREE — THE SOLAR PLEXUS CENTER (TIFERET)",
        subtitle = "Will, Identity, Transformation",
        biblicalAnchor = "“Taste and see that the LORD is good.” — Psalm 34:8",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Tiferet",
                "Tiferet is the harmonizing point between Chesed (expansion) and Gevurah (restriction). It is the seat of mature will."
            ),
            Section(
                "Scientific Correlation — The Celiac Ganglion",
                "This “second brain” governs digestion, stress response, and intuitive knowing."
            )
        ),
        practices = listOf(
            "Boundary setting",
            "Emotional digestion",
            "Transforming reactive fire into purposeful fire"
        ),
        summary = "The Solar Plexus is the refiner’s fire of the human system."
    ),
    Chapter(
        id = "ch4",
        title = "CHAPTER FOUR — THE HEART CENTER (CHESED / GEVURAH)",
        subtitle = "Compassion, Boundaries, Coherence",
        biblicalAnchor = "“Guard your heart with all diligence, for out of it flow the issues of life.” — Proverbs 4:23",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Chesed and Gevurah",
                "The Heart reconciles expansion and restriction into wise compassion."
            ),
            Section(
                "Scientific Correlation — HRV and the Thymus",
                "The heart’s intrinsic nervous system and the thymus gland regulate emotional resilience and immune function."
            )
        ),
        practices = listOf(
            "Coherence breathing",
            "Forgiveness",
            "Compassion with boundaries"
        ),
        summary = "The Heart is the center of integration."
    ),
    Chapter(
        id = "ch5",
        title = "CHAPTER FIVE — THE THROAT CENTER (DA’AT)",
        subtitle = "Truth, Expression, Alignment",
        biblicalAnchor = "“In the beginning was the Word.” — John 1:1",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Da’at",
                "Da’at is the hidden sefirah, the fusion of wisdom and understanding into expressible knowledge."
            ),
            Section(
                "Scientific Correlation — Vagus Nerve and Thyroid",
                "Vocalization regulates the nervous system and metabolic balance."
            )
        ),
        practices = listOf(
            "The Aleph meditation",
            "Humming and toning",
            "Boundary statements",
            "Speech review"
        ),
        summary = "The Throat is the birth canal of reality."
    ),
    Chapter(
        id = "ch6",
        title = "CHAPTER SIX — THE BROW CENTER (BINAH)",
        subtitle = "Perception, Discernment, Insight",
        biblicalAnchor = "“If your eye is single, your whole body will be full of light.” — Matthew 6:22",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Binah",
                "Binah is the Palace of Mirrors, the womb of understanding."
            ),
            Section(
                "Scientific Correlation — Pineal and Prefrontal Cortex",
                "These structures govern intuition, insight, and symbolic perception."
            )
        ),
        practices = listOf(
            "Candle gazing",
            "Dream recording",
            "Perspective shifting",
            "Indigo visualization"
        ),
        summary = "The Brow is the lamp of the body."
    ),
    Chapter(
        id = "ch7",
        title = "CHAPTER SEVEN — THE CROWN CENTER (KETER)",
        subtitle = "Unity, Awareness, Transcendence",
        biblicalAnchor = "“A throne set in heaven.” — Revelation 4:2",
        sections = listOf(
            Section(
                "Kabbalistic Foundation — Keter and Ayin",
                "Keter is pure will; Ayin is the nothingness beyond form."
            ),
            Section(
                "Scientific Correlation — Gamma Coherence and DMN Deactivation",
                "Unity consciousness corresponds to global neural synchronization and the quieting of the egoic self."
            )
        ),
        practices = listOf(
            "Stillness",
            "Vertical alignment",
            "Breath of union",
            "Contemplation of oneness"
        ),
        summary = "The Crown is the realization of the Primordial Human."
    )
)

val Appendices = listOf(
    Appendix(
        id = "app_a",
        title = "APPENDIX A — CROSS‑CULTURAL CORRESPONDENCE MATRIX",
        content = "A unified table showing how the seven centers appear across major spiritual, mystical, and physiological systems.",
        items = listOf(
            "Root: Malkuth | Muladhara | Nafs | Djed Base | Genesis 2:7 | HPA Axis",
            "Sacral: Yesod | Svadhisthana | Lataif‑e‑Nafs | Hips/Waters | John 7:38 | ENS / HPG Axis",
            "Solar Plexus: Tiferet | Manipura | Qalb | Solar Disk | Psalm 34:8 | Celiac Ganglion",
            "Heart: Chesed/Gevurah | Anahata | Sirr | Heart Chamber | Proverbs 4:23 | HRV / Thymus",
            "Throat: Da’at | Vishuddha | Khafi | Throat Gate | John 1:1 | Vagus / Thyroid",
            "Brow: Binah | Ajna | Akhfa | Eye of Horus | Matthew 6:22 | Pineal / PFC",
            "Crown: Keter | Sahasrara | Fana | Sun Crown | Revelation 4:2 | Gamma / DMN"
        )
    ),
    Appendix(
        id = "app_b",
        title = "APPENDIX B — CHRISTOLOGICAL CLARIFICATION",
        content = "The New Testament presents Christ as the archetype of integrated humanity, mirroring the Kabbalistic Adam Kadmon. The seven centers map onto the threefold Temple structure: Outer Court (Root, Sacral, Solar), Holy Place (Heart, Throat), and Holy of Holies (Brow, Crown)."
    ),
    Appendix(
        id = "app_c",
        title = "APPENDIX C — HEAVEN & HELL AS STATES OF CONSCIOUSNESS",
        content = "Heaven: A state of unity, coherence, and divine awareness. Correlates with Crown activation and global neural integration.\n\nHell: A state of fragmentation, fear, and disconnection. Correlates with Root dysregulation, sympathetic dominance, and ego‑fire."
    ),
    Appendix(
        id = "app_d",
        title = "APPENDIX D — CREATION, VIBRATION & THE ENERGY BODY",
        content = "Speech is vibration. Vibration is structure. Structure is creation. The Throat Center is the human participation in this divine mechanism. Each center vibrates at a distinct frequency, forming a harmonic ladder, with breath as the carrier wave."
    ),
    Appendix(
        id = "app_e",
        title = "APPENDIX E — ROMAN INFLUENCE & ESOTERIC SUPPRESSION",
        content = "Early Christian mysticism was reshaped by Roman political structures. Mystical, experiential practices were replaced with institutional authority, and teachings on breath, body, and inner ascent were marginalized. The seven‑center system survived only in esoteric streams (Kabbalah, Hesychasm, Sufism)."
    ),
    Appendix(
        id = "app_f",
        title = "APPENDIX F — SOMATIC DISCERNMENT",
        content = "A practical guide for distinguishing intuition from trauma. True intuition brings calm clarity, no urgency, expansive sensation, and consistency with values. Trauma impulses bring tightness, urgency, fear‑based logic, and fragmented thinking."
    )
)

val Glossary = listOf(
    "Adamah" to "Hebrew for ground, earth, soil. Foundation of the Root Center.",
    "Ayin" to "Hebrew letter meaning eye and spring; governs the Brow Center. Also \"Nothingness,\" the pre-form state of the Infinite.",
    "Binah" to "Third sefirah. “Understanding.” Governs the Brow Center.",
    "Chesed & Gevurah" to "Expansion/compassion and restriction/boundaries. The polarities of the Heart Center.",
    "Da’at" to "The hidden sefirah. “Knowledge.” Governs the Throat Center.",
    "Keter" to "First sefirah. “Crown.” Pure will, unity, and transcendence.",
    "Malkuth" to "Tenth sefirah. “Kingdom.” Physical manifestation and grounding.",
    "Shekhinah" to "Indwelling divine presence. Dwells in Malkuth.",
    "Tiferet" to "Sixth sefirah. Harmony, beauty, balanced will.",
    "Yesod" to "Ninth sefirah. Foundation of generative flow."
)
