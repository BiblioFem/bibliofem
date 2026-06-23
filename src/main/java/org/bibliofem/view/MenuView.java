package org.bibliofem.view;

import org.bibliofem.utils.ConsoleColors;

public class MenuView {
    public MenuView() {
        System.out.println(
                ConsoleColors.PURPLE +
                """
                                     /\\___/\\
                                    ( =^.^= )
                                     (")_(")
                        """
        );
        System.out.println(
                        "╔══════════════════════════════╗");
        System.out.println(
                        "║     BIBLIOTECA FEMINISTA     ║");
        System.out.println(
                        "╚══════════════════════════════╝" +
                ConsoleColors.RESET
        );
    }
}
