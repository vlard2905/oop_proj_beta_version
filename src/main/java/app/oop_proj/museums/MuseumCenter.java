package app.oop_proj.museums;

import java.util.ArrayList;
import java.util.List;

public class MuseumCenter { //Composite pattern.
    private List<String> rules = new ArrayList<>();

    public void addSpecialRule(String rule) {
        rules.add(rule);
    }

    public void removeSpecialRule(String rule) {
        rules.remove(rule);
    }
    public String getGeneralMuseumRules() {
        rules.add("Do not touch works of art. Your touch may not seem" +
                " like much, but even the slightest contact can damage " +
                "the surface of a painting, discolor stone, and even rust metal.\n");
        rules.add("Keep a safe distance between you and each " +
                "work of art. This helps to avoid accidental touching or bumping.\n");
        rules.add("Use only pencils. If an accident should occur," +
                " a pencil mark is easier to remove than a pen mark. Members" +
                " of the security and visitor services staff are happy" +
                " to provide a pencil if you would like to write or " +
                "draw during your museum visit. Be careful not to point " +
                "with your pencil or other objects; this can endanger works of art.\n");
        rules.add("No leaning on walls or cases (either to write or for" +
                " physical support). This helps keep works of art hung" +
                " on the walls or displayed in cases safe. Feel free to sit" +
                " on the benches or the floor as you talk, write, or draw.\n");
        rules.add("No food, drink, or gum is allowed in the galleries. " +
                "The art in the museum will provide plenty of food for thought " +
                "as well as a feast for the eyes!\n");
        rules.add("Coats: Visitors are allowed to wear coats in the museum," +
                " but the coats must remain on, never carried, at all times" +
                " for the safety of the art. Coats may also be left in the" +
                " coat room.\n");
        rules.add("Running, pushing, and roughhousing are not allowed" +
                " in the museum. Appropriate museum behavior is necessary" +
                " to avoid accidentally bumping into and damaging works of art.\n");
        rules.add("Photography: We welcome visitors to photograph or " +
                "videotape works of art owned by the Hood Museum of" +
                " Art (Trustees of Dartmouth College) for personal " +
                "use only. No flash, please! Please be aware that" +
                " occasionally a “no photography” symbol on a label " +
                "adjacent to a work of art or at the entrance to an " +
                "exhibition indicates that photography is prohibited" +
                " for that work or exhibition.");
        return rules.toString();
    }
}
