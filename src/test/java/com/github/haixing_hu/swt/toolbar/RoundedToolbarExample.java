/*******************************************************************************
 * Copyright (c) 2012 Laurent CARON.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Laurent CARON (laurent.caron at gmail dot com) - initial API and implementation
 *     Haixing Hu (https://github.com/Haixing-Hu/)  - Modification for personal use.
 *******************************************************************************/
package com.github.haixing_hu.swt.toolbar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.github.haixing_hu.swt.utils.SWTResourceManager;

/**
 * A simple snippet for the {@link RoundedToolbar} widget.
 */
public class RoundedToolbarExample {

  //private static Color grey1;
  private static Color grey2;
  private static Image iconBubble1b;
  private static Image iconBubble1w;
  private static Image iconBubble2b;
  private static Image iconBubble2w;
  private static Image iconBubble3b;
  private static Image iconBubble3w;
  private static Image emailb;
  private static Image emailw;

  /**
   * @param args
   */
  public static void main(final String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("RoundedToolbar Example");
    final GridLayout gridLayout = new GridLayout();
    gridLayout.horizontalSpacing = 20;
    shell.setLayout(gridLayout);

    //grey1 = SWTResourceManager.getColor(display, 211, 211, 211);
    grey2 = SWTResourceManager.getColor(display, 255, 250, 250);
    iconBubble1b = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble1_b.png");
    iconBubble1w = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble1_w.png");

    iconBubble2b = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble2_b.png");
    iconBubble2w = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble2_w.png");

    iconBubble3b = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble3_b.png");
    iconBubble3w = SWTResourceManager.getImage(display,
        RoundedToolbarExample.class, "/images/bubble3_w.png");

    emailb = SWTResourceManager.getImage(display, RoundedToolbarExample.class,
        "/images/email_b.png");
    emailw = SWTResourceManager.getImage(display, RoundedToolbarExample.class,
        "/images/email_w.png");

    createFirstToolbar(shell);
    createSecondToolbar(shell);
    createThirdToolbar(shell);
    shell.open();
    while (! shell.isDisposed()) {
      if (! display.readAndDispatch()) {
        display.sleep();
      }
    }
    SWTResourceManager.dispose();
    display.dispose();
  }

  private static void createFirstToolbar(final Shell shell) {
    final RoundedToolbar roundedToolBar = new RoundedToolbar(shell, SWT.NONE);

    roundedToolBar.setMultiselection(true);
    //roundedToolBar.setBackground(grey1);
    roundedToolBar.setCornerRadius(6);

    roundedToolBar.addControlListener(new ControlListener() {

      @Override
      public void controlResized(final ControlEvent e) {
        System.out.println(roundedToolBar.getSize());

      }

      @Override
      public void controlMoved(final ControlEvent e) {
        // TODO Auto-generated method stub

      }
    });

    final RoundedToolItem item1 = new RoundedToolItem(roundedToolBar);
    item1.setSelection(true);
    item1.setTooltipText("Multiple ballons");
    item1.setWidth(40);
    item1.setSelectionImage(iconBubble3w);
    item1.setImage(iconBubble3b);

    final RoundedToolItem item2 = new RoundedToolItem(roundedToolBar);
    item2.setTooltipText("Simple item");
    item2.setSelectionImage(iconBubble1w);
    item2.setImage(iconBubble1b);
    item2.setWidth(40);

    final RoundedToolItem item3 = new RoundedToolItem(roundedToolBar);
    item3.setTooltipText("Lot of lines\r\n\r\nThis item has a line-break");
    item3.setSelectionImage(iconBubble2w);
    item3.setImage(iconBubble2b);
    item3.setWidth(40);
  }

  private static void createSecondToolbar(final Shell shell) {
    final RoundedToolbar roundedToolBar2 = new RoundedToolbar(shell, SWT.NONE);
    roundedToolBar2.setCornerRadius(8);
    //roundedToolBar2.setBackground(grey1);

    final RoundedToolItem mailItem = new RoundedToolItem(roundedToolBar2);
    mailItem.setSelectionImage(emailw);
    mailItem.setImage(emailb);
    mailItem.setWidth(32);
    mailItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar2/Button 1");
      }
    });

    final RoundedToolItem mailItemWithText = new RoundedToolItem(
        roundedToolBar2);
    mailItemWithText.setTextColorSelected(grey2);
    mailItemWithText.setText("Mails");
    mailItemWithText.setSelectionImage(emailw);
    mailItemWithText.setImage(emailb);
    mailItemWithText.setWidth(65);
    mailItemWithText.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar2/Button 2");
      }
    });

    final RoundedToolItem itemJustText = new RoundedToolItem(roundedToolBar2);
    itemJustText.setTextColorSelected(grey2);
    itemJustText.setText("Just text");
    itemJustText.setWidth(100);
    itemJustText.setAlignment(SWT.RIGHT);
    itemJustText.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar2/Button 3");
      }
    });
  }

  private static void createThirdToolbar(final Shell shell) {
    final RoundedToolbar roundedToolBar2 = new RoundedToolbar(shell, SWT.NONE, 18);
    //roundedToolBar2.setBackground(grey1);

    final RoundedToolItem mailItem = new RoundedToolItem(roundedToolBar2);
    mailItem.setSelectionImage(emailw);
    mailItem.setImage(emailb);
    mailItem.setWidth(32);
    mailItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar3/Button 1");
      }
    });

    final RoundedToolItem mailItemWithText = new RoundedToolItem(
        roundedToolBar2);
    mailItemWithText.setTextColorSelected(grey2);
    mailItemWithText.setText("Mails");
    mailItemWithText.setSelectionImage(emailw);
    mailItemWithText.setImage(emailb);
    mailItemWithText.setWidth(65);
    mailItemWithText.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar3/Button 2");
      }
    });

    final RoundedToolItem itemJustText = new RoundedToolItem(roundedToolBar2);
    itemJustText.setTextColorSelected(grey2);
    itemJustText.setText("Just text");
    itemJustText.setWidth(100);
    itemJustText.setAlignment(SWT.RIGHT);
    itemJustText.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        System.out.println("Bar3/Button 3");
      }
    });
  }
}
