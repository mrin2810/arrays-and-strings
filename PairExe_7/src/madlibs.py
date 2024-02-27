import random  # shuffle
import sys     # stderr.write

"""
CSCI-142 Computer Science 2 Recitation Exercise
07-ExceptionsIO
Mad Libs

A program that generates a random madlib from a template and a collection of
words.

:author RIT CS
"""
class MadLibs:
    """
    A class that reads in Mad Libs files and produces a story at random.

    :slots: madlibs:  a dictionary of madlib marker words to a list
    of possible strings to replace the marker with.

    :slots template: the template with regular words and marker words
    that gets tokenized into a tuple of strings.
    """

    __slots__ = 'madlibs', 'template'

    # file names for words and template
    ADJECTIVES = 'adjectives.txt'
    NOUNS = 'nouns.txt'
    PEOPLE = 'people.txt'
    TEMPLATE = 'template.txt'
    VERBS = 'verbs.txt'

    # the mad lib marker strings in the template that will get replaced
    # with randomly selected text
    ADJECTIVE_MARKER = '<ADJECTIVE>'
    NOUN_MARKER = '<NOUN>'
    PERSON_MARKER = '<PERSON>'
    VERB_MARKER = '<VERB>'

    # how many characters to print in a line
    LINE_LENGTH = 80

    def __init__(self):
        """
        Constructor of MadLibs objects.
        """

        # create the madlib dictionary that maps the madlib tags,
        # e.g. <NOUN> to a list of shuffled nouns as the key
        self.madlibs = {}

        # read in the adjectives, shuffle, and add to the map
        with open(MadLibs.ADJECTIVES) as f:
            adjectives = []
            for adjective in f:
                adjectives.append(adjective.strip())
            random.shuffle(adjectives)
            self.madlibs[MadLibs.ADJECTIVE_MARKER] = adjectives

        # read in the nouns, shuffle, and add to the map
        with open(MadLibs.NOUNS) as f:
            nouns = []
            for noun in f:
                nouns.append(noun.strip())
            random.shuffle(nouns)
            self.madlibs[MadLibs.NOUN_MARKER] = nouns

        # read in the people, shuffle, and add to the map
        with open(MadLibs.PEOPLE) as f:
            people = []
            for person in f:
                people.append(person.strip())
            random.shuffle(people)
            self.madlibs[MadLibs.PERSON_MARKER] = people

        # read in the verbs, shuffle, and add to the map
        with open(MadLibs.VERBS) as f:
            verbs = []
            for verb in f:
                verbs.append(verb.strip())
            random.shuffle(verbs)
            self.madlibs[MadLibs.VERB_MARKER] = verbs

        # read in the template into a tuple of strings
        with open(MadLibs.TEMPLATE) as f:
            self.template = tuple(f.read().strip().split())

    def produce(self):
        """
        Generate the random story now that the collections have been created.
        """

        chars = 0
        # loop over each string in the template
        for word in self.template:
            # if it is a "regular" word save it
            if word not in self.madlibs:
                str = word
            else:
                # if it is a marker word, pop the next relevant string
                # off the front of the list for the marker word
                str = self.madlibs[word].pop(0)

            # print the word
            print(str, end=' ')

            # check if we exceed the line length - if so print a new line
            chars += len(str)
            if chars > MadLibs.LINE_LENGTH:
                print()
                chars = 0

def main():
    """
    The main method.
    """
    try:
        # create the object by reading in the files into the structures
        madlibs = MadLibs()
        # generate the madlib
        madlibs.produce()
    except FileNotFoundError as fnfe:
        # if a file cannot be read an exception will be thrown and caught here
        sys.stderr.write(str(fnfe))
    finally:
        print('\n\n"We all float down here!', b'\xF0\x9F\x8E\x88'.decode('utf-8'))

if __name__ == '__main__':
    main()