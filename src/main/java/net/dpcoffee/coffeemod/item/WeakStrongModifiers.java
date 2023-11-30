package net.dpcoffee.coffeemod.item;

public enum WeakStrongModifiers {
    WEAK("Weak "),
    STRONG("Strong "),
    NONE("");
    final String mod_name;

    WeakStrongModifiers(String name) {
        mod_name = name;
    }
}
