package com.shizubro.mtgmarket.service;

import com.shizubro.mtgmarket.model.ListingDTO;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Component("storeScraperService")
public class StoreScraperService {
    private static final String SERRA_URL = "https://cardshop-serra.com";
    private static final String HARERUYA_URL = "https://www.hareruyamtg.com";

    // get card price aggregates from all sites
    public Set<ListingDTO> getCardPriceByName(String cardName) {
        try {
//            getSerraPrice(cardName);
            getHareruyaPrice(cardName);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
        return Set.of();
    }

    // get card price aggregates from hareruya
    public Set<ListingDTO> getHareruyaPrice(String cardName) throws IOException {
        return this.getHareruyaListingsFromUrl(this.HARERUYA_URL + "/ja/products/search?product=" + cardName);

    }

    private Set<ListingDTO> getHareruyaListingsFromUrl(String fetchUrl) throws IOException {
        Document doc = Jsoup.connect(String.format(fetchUrl)).get();
        Elements listingResults = doc.select("ul.itemListLine");
        log.info(String.valueOf(listingResults.first()));
        Elements pageNumbers = doc.select("a.page_num");
        int currentPage = Integer.parseInt(doc.select("span.now_").first().text());
        String nextPageUrl = "";
        for (Element page : pageNumbers) {
            if (Integer.parseInt(page.text()) > currentPage) {
                log.info(String.valueOf(currentPage));
                nextPageUrl = page.attr("href");
                break;
            }
        }
        if (nextPageUrl != "") {
            getHareruyaListingsFromUrl(nextPageUrl);
        }
        return Set.of();
    }

    // get card price aggregates from cardshop serra
    public Set<ListingDTO> getSerraPrice(String cardName) throws IOException {
        return this.getSerraListingsFromUrl("/mtg/products/list?name=" + cardName);
    }

    private Set<ListingDTO> getSerraListingsFromUrl(String fetchUrl) throws IOException {
        Document doc = Jsoup.connect(String.format(this.SERRA_URL + fetchUrl)).get();
        Elements listingResults = doc.select("div.product-list__item");
        log.info(String.valueOf(listingResults.size()));
        for (Element listing : listingResults) {
            List<String> listingPriceList = new ArrayList<String>();
            Element listingTitle = listing.selectFirst("a.product-list__item__title--name");
            Elements listingPrices = listing.selectFirst("tbody").children();
            log.info(listingTitle.text());
            for (Element listingPrice : listingPrices) {
                if (listingPrice.classNames().contains("product-list__item__table__nostock")) {
                    continue;
                }
                log.info("listing price");
                log.info(listingPrice.text());
                listingPriceList.add(listingPrice.text());
            }
            if (listingPriceList.isEmpty()) {
                continue;
            }

//            log.info(
//                    listing.text());// , listing.absUrl("href")));
        }
        log.info("even more things");
        Element nextPageElement = doc.select("li.pager-normal__item--next > a").first();
        if (nextPageElement != null) {
            String nextPageUrl = nextPageElement.attr("href");
            log.info(String.valueOf(nextPageUrl));
            this.getSerraListingsFromUrl(nextPageUrl.replaceAll("%20", "+"));
        }
        return Set.of();
    }
}
