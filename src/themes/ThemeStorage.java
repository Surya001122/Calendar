package themes;

import java.util.HashMap;
class ThemeStorage {
    private final HashMap<String,Theme> userThemes = new HashMap<>();
    private static ThemeStorage themeStorage = null;

    private ThemeStorage() {}

    public static ThemeStorage getInstance() {
        if (themeStorage == null) {
            themeStorage = new ThemeStorage();
        }
        return themeStorage;
    }
    Theme getUserThemeList(String userId){
        if(userThemes.containsKey(userId)){
            return userThemes.get(userId);
        }
        return null;
    }
    void createThemesForUserCalendar(String userId,Theme theme){
        userThemes.put(userId,theme);
    }
}
