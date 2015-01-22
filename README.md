## Wierd pseudo-names error:

To reproduce:

**This breaks** with `TypeError: undefined is not a function (evaluating '(void 0)()')`:

```
boot from-cljsjs reload cljs -O advanced -c "{:pseudo-names false}"
```

after removing the `reload` task it works:

```
boot from-cljsjs cljs -O advanced -c "{:pseudo-names false}"
```

equally it works if you remove Reagent:

```
```
