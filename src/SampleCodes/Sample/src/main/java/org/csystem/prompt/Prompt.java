package org.csystem.prompt;

import com.karandev.io.util.console.Console;

public final class Prompt {
    private final String [] m_values = {
            PromptInfo.TITLE.defaultValue,
            PromptInfo.MESSAGE.defaultValue,
            PromptInfo.POSITIVE_OPTION.defaultValue,
            PromptInfo.NEGATIVE_OPTION.defaultValue,
            PromptInfo.NEUTRAL_OPTION.defaultValue,
            PromptInfo.OPTION_MESSAGE.defaultValue
    };

    private enum PromptInfo {
        TITLE(""),
        MESSAGE(""),
        POSITIVE_OPTION(""),
        NEGATIVE_OPTION(""),
        NEUTRAL_OPTION(""),
        OPTION_MESSAGE("Option:");

        final String defaultValue;

        PromptInfo(String defaultValue)
        {
            this.defaultValue = defaultValue;
        }
    };

    public static class Builder {
        private final Prompt m_prompt;
        private Builder()
        {
            m_prompt = new Prompt();
        }

        public Builder setTitle(String title)
        {
            m_prompt.m_values[PromptInfo.TITLE.ordinal()] = title;

            return this;
        }

        public Builder setMessage(String message)
        {
            m_prompt.m_values[PromptInfo.MESSAGE.ordinal()] = message;

            return this;
        }

        public Builder setPositiveOption(String option)
        {
            m_prompt.m_values[PromptInfo.POSITIVE_OPTION.ordinal()] = option;

            return this;
        }

        public Builder setNegativeOption(String option)
        {
            m_prompt.m_values[PromptInfo.NEGATIVE_OPTION.ordinal()] = option;

            return this;
        }

        public Builder setNeutralOption(String option)
        {
            m_prompt.m_values[PromptInfo.NEUTRAL_OPTION.ordinal()] = option;

            return this;
        }

        public Builder setOptionMessage(String optionMessage)
        {
            m_prompt.m_values[PromptInfo.OPTION_MESSAGE.ordinal()] = optionMessage;

            return this;
        }

        public static Builder builder()
        {
            return new Builder();
        }

        public Prompt build()
        {
            return m_prompt;
        }
    }

    public char show()
    {
        if (m_values[PromptInfo.TITLE.ordinal()] != null && !m_values[PromptInfo.TITLE.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.TITLE.ordinal()]);

        if (m_values[PromptInfo.MESSAGE.ordinal()] != null && !m_values[PromptInfo.MESSAGE.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.MESSAGE.ordinal()]);

        if (m_values[PromptInfo.POSITIVE_OPTION.ordinal()] != null && !m_values[PromptInfo.POSITIVE_OPTION.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.POSITIVE_OPTION.ordinal()]);

        if (m_values[PromptInfo.NEGATIVE_OPTION.ordinal()] != null && !m_values[PromptInfo.NEGATIVE_OPTION.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.NEGATIVE_OPTION.ordinal()]);

        if (m_values[PromptInfo.NEUTRAL_OPTION.ordinal()] != null && !m_values[PromptInfo.NEUTRAL_OPTION.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.NEUTRAL_OPTION.ordinal()]);

        if (m_values[PromptInfo.OPTION_MESSAGE.ordinal()] != null && !m_values[PromptInfo.OPTION_MESSAGE.ordinal()].isBlank())
            Console.writeLine(m_values[PromptInfo.OPTION_MESSAGE.ordinal()]);

        return Console.readChar();
    }
}
