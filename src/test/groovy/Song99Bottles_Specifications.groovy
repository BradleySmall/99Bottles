import spock.lang.Specification

class Song99Bottles_Specifications extends Specification {
    def "should show '99 Bottles' for 99"() {
        expect:

        RESULT == new Song99Bottles().verse(NUMBER)

        where:

        NUMBER | RESULT
            99 | "Ninety-nine bottles of beer on the wall, ninety-nine bottles of beer. Take one down, pass it around, " +
                    "ninety-eight bottles of beer on the wall."
             1 | "One bottle of beer on the wall, one bottle of beer. Take one down, pass it around, no bottles of beer on the " +
                     "wall."
             2 | "Two bottles of beer on the wall, two bottles of beer. Take one down, pass it around, one bottle of beer on the " +
                     "wall."
             0 | "No bottles of beer on the wall, no bottles of beer. Go to the store, buy some more, ninety-nine bottles of " +
                     "beer on the wall."
    }

    def "play the song"() {
        for (int i = 99; i >= 0; --i) {
            println(new Song99Bottles().verse(i))
        }

        expect:
        1 == 1
    }
}
