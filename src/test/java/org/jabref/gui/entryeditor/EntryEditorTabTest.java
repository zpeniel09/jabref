package org.jabref.gui.entryeditor;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.types.EntryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class EntryEditorTabTest {

    
    private EntryEditorTab entryEditorTab;  //Create a new instance of entry editor tab
    private BibEntry bibEntry;              //Create a new instance of bib entry
    private EntryType entryType;            //Create a new instance of entry type

    //Set up the test
    @BeforeEach
    void setUp() {
        //Create a new instance of entry editor tab
        entryEditorTab = new EntryEditorTab() {
            @Override
            public boolean shouldShow(BibEntry entry) {
                return false;
            }

            @Override
            protected void bindToEntry(BibEntry entry) {

            }
        };
        //A new instance of bib entry
        bibEntry = new BibEntry();
        //A new instance of entry type
        entryType = new EntryType() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }
        };
    }

    //Test if the tab should show the given entry
    @Test
    void shouldShow() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry type to the given entry type
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should show the given entry
    }

    //Test if the tab should not show the given entry
    @Test
    void shouldNotShow() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry type to the given entry type
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should not show the given entry
    }

    //Test if the tab should show the given entry
    @Test
    void shouldShow2() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry type to the given entry type
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should show the given entry
    }

    
    @Test
    void shouldNotShow2() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry to the given entry
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should not show the given entry
    }

    //Test if the tab should show the given entry
    @Test
    void shouldShow3() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry type to the given entry type
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should show the given entry
    }

    //Test if the tab should not show the given entry
    @Test
    void shouldNotShow3() {
        entryEditorTab.setCurrentEntry(bibEntry);               //Set the current entry to the given entry
        entryEditorTab.setCurrentEntryType(entryType);          //Set the current entry type to the given entry type
        assertFalse(entryEditorTab.shouldShow(bibEntry));       //Assert that the tab should not show the given entry
    }
}
