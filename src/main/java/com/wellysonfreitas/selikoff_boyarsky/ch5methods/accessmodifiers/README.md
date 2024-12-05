# Reviewing Access Modifiers

A method in _______ can access _______ member.

|                                           | private | package | protected | public |
|-------------------------------------------|---------|---------|-----------|--------|
| the same class                            | Yes     | Yes     | Yes       | Yes    |
| another class in the same package         | No      | Yes     | Yes       | Yes    |
| a subclass in a different package         | No      | No      | Yes       | Yes    |
| an unrelated class in a different package | No      | No      | No        | Yes    |
