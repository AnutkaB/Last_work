package ru.iteco.fmhandroid.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {

    public ViewInteraction version = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction privacyPolicyTitle = onView(withText(R.string.privacy_policy));
    public ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction termsOfUseTitle = onView(withText(R.string.terms_of_use));
    public ViewInteraction companyInfo = onView(withId(R.id.about_company_info_label_text_view));
    public ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
}
